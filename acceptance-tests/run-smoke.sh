#!/bin/bash

JAR="target/demo-maven-gitflow-1.0-SNAPSHOT.jar"

echo "Ejecutando acceptance test..."

# Verifica que el JAR exista
if [ ! -f "$JAR" ]; then
    echo "❌ JAR no encontrado"
    exit 1
fi

# Ejecuta el JAR y verifica que imprima "Hello World!"
java -jar "$JAR" | grep "Hello World" > /dev/null
if [ $? -eq 0 ]; then
    echo "✅ Acceptance test OK"
    exit 0
else
    echo "❌ Acceptance test falló"
    exit 1
fi
