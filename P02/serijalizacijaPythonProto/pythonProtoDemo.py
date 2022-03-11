import requests
import students_pb2

resp = requests.get('http://localhost:8080/api/ocene')

ocene = students_pb2.Ocene()
ocene.ParseFromString(resp.content)

print(ocene)
