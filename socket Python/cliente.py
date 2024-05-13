# Cliente
import socket

s = socket.socket()
host = socket.gethostname()
puerto = 12345

s.connect((host, puerto))
print(s.recv(1024))
s.close()
