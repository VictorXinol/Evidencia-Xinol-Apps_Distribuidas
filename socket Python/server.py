# Servidor
import socket

s = socket.socket()
print("Socket creado")

puerto = 12345
s.bind(('', puerto))
print("Socket vinculado al puerto", puerto)

s.listen(5)
print("Socket está escuchando")

while True:
   c, addr = s.accept()
   print('Conexión entrante desde', addr)
   c.send('Gracias por conectarte')
   c.close()
