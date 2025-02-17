#!/bin/bash
SA_PASSWORD="@sa12345"
##Script to run inside docker container

pastas=("CREATE" "INSERT")

arquivos=$(ls /tmp/scripts/*/*.sql -1)
echo "Executando pasta $pasta"

for arquivo in $arquivos
do
  echo "Executing file: $arquivo"
  /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -i $arquivo -C
  echo "$arquivo executed successfully"
done
