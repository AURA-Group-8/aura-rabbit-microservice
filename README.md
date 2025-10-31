# 💻 aura-rabbit-microservice

Este é o microsserviço do projeto **Aura**, desenvolvido pelo **Grupo 8**. Ele Funciona como sistema de mensageria para entrega de Email mensagens de WhatsApp

## 💼 Equipe do projeto

- [@Bruna Karen](https://github.com/brunaK19)
- [@Gustavo Basi](https://github.com/GustavoBasi)
- [@Luiz Felipe](https://github.com/LuizFelipeSptech)
- [@Murillo Lima](https://github.com/Murillo-lc)
- [@Pablo Rocha](https://github.com/AlbaDr52)
- [@Richard Almeida](https://github.com/richpdp)

## ⚙️ Tecnologias Utilizadas

- ☕ **Java 21**
- 🚀 **Spring Boot 3.4.3**
- 📲 **Twilio API** para envio de mensagens via WhatsApp
- 🛡️ **Spring Security** para segurança
- ✉️ **Spring Mail** para envio de e-mails

## ✨ Funcionalidades

### 💬 Mensagens
- Envio de mensagens via WhatsApp para os usuários
- Envio de tokens para redefinição de senha via e-mail

## 🛠️ Configuração do Ambiente

### ✅ Pré-requisitos
- ☕ **Java 21** instalado
- 🛠️ **Maven** configurado

### 🔐 Variáveis de Ambiente

Configure as seguintes variáveis no arquivo `application.properties` ou como variáveis de ambiente:


#### 📲 Twilio
- `TWILIO_SID`: SID da conta Twilio
- `TWILIO_AUTH`: Token de autenticação da Twilio

#### 📧 E-mail
- `EMAIL_USERNAME`: Endereço de e-mail usado para envio
- `EMAIL_PASSWORD`: Senha do e-mail configurado para envio

#### 📧 RabbitMQ
- `RABBITMQ_HOST`: ip/hostname do RabbitMQ
- `RABBITMQ_USER`: Usuário com permissão de recebimento de mensagens e criação de filas
- `RABBITMQ_PASSWORD`: Senha do usuário configurado

## ▶️ Executando o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/AURA-Group-8/aura-rabbit-microservice.git
   cd aura-rabbit-microservice
