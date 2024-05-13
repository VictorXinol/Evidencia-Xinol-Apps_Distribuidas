from flask import Flask, render_template
from flask_socketio import SocketIO, emit

# Configuración
app = Flask(__name__)
app.config["SECRET_KEY"] = "secret-key"
socketio = SocketIO(app)

# Variables
players = {}
game_state = {
  "flipped_cards": [],
  "turn": 0,
  "scoreboard": {},
}

# Rutas
@app.route("/")
def index():
  return render_template("index.html")

# Eventos de SocketIO
@socketio.on("connect")
def on_connect():
  print("¡Cliente conectado!")

@socketio.on("disconnect")
def on_disconnect():
  print("Cliente desconectado")

@socketio.on("flip-card")
def on_flip_card(card_id):
  # Voltear la carta en el servidor
  game_state["flipped_cards"].append(card_id)

  # Comprobar si hay una pareja
  if len(game_state["flipped_cards"]) == 2:
    if game_state["flipped_cards"][0] == game_state["flipped_cards"][1]:
      # ¡Pareja encontrada!
      emit("match", {"card1Id": game_state["flipped_cards"][0], "card2Id": game_state["flipped_cards"][1]})
      # Actualizar el marcador
      game_state["scoreboard"][players[socketio.sid]] += 1
      emit("update-scoreboard", game_state["scoreboard"])
      # Restablecer las cartas volteadas
      game_state["flipped_cards"] = []
    else:
      # No hay pareja
      emit("no-match")
      # Cambiar de turno
      game_state["turn"] = (game_state["turn"] + 1) % len(players)
      emit("turn", game_state["turn"])

  # Comprobar si el juego ha terminado
  if len(game_state["flipped_cards"]) == 0 and len(list(filter(lambda x: x < 2, game_state["scoreboard"].values()))) == 0:
    # ¡Juego terminado!
    winner = max(game_state["scoreboard"], key=game_state["scoreboard"].get)
    emit("game-over", winner)

@socketio.on("join-game")
def on_join_game(username):
  # Unirse al juego
  players[socketio.sid] = username
  game_state["scoreboard"][username] = 0
  emit("player-joined", username)

  # Si ya hay dos jugadores, iniciar el juego
  if len(players) == 2:
    emit("start", game_state["turn"])

# Función para determinar el ganador
def get_winner(scoreboard):
  return max(scoreboard, key=scoreboard.get)

# Función para reiniciar el juego
def reset_game():
  game_state["flipped_cards"] = []
  game_state["turn"] = 0
  game_state["scoreboard"] = {}

if __name__ == "__main__":
  socketio.run(app)
