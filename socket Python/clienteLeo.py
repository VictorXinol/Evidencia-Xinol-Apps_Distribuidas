"""import socket

HOST = '192.168.137.1'  # Dirección IP del servidor
PORT = 40000           # Número de puerto del servidor

def start_client():
    ""Inicia el cliente y se conecta al servidor""
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((HOST, PORT))

    while True:
        message = input('Escribe tu mensaje: ')
        client_socket.send(message.encode())
        data = client_socket.recv(1024)
        print(f'Recibido: {data.decode()}')

if __name__ == '__main__':
    start_client()"""

# Cliente

import socket

SERVER_IP = "192.168.137.1"
SERVER_PORT = 5000

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

while True:
    msg = input("Mensaje a enviar: ")
    sock.sendto(msg.encode(), (SERVER_IP, SERVER_PORT))

    data, addr = sock.recvfrom(1024)
    print("Recibido: ", data.decode())