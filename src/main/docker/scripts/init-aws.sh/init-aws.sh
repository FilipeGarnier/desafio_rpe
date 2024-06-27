#!/bin/bash

# Cria fila
awslocal sqs create-queue --queue-name cartao-queue
# Inscreve a fila no tópico
awslocal --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:cartao-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:cartao-queue