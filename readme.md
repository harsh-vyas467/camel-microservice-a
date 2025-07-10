## 🚀 ActiveMQ (Standalone via Docker)

To run ActiveMQ using Docker:


docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
61616: Broker connection port (for applications).

8161: Admin web console port.

🔗 Access the ActiveMQ web console at: http://localhost:8161

🔁 Kafka (Using docker-compose)
Kafka is installed and managed using Docker Compose.

Steps:
Navigate to the directory where your docker-compose.yml file is located.

Run the following command:

docker-compose up
To run it in the background (detached mode), use:


docker-compose up -d
This will start Kafka, Zookeeper, and any additional services defined in the file.

