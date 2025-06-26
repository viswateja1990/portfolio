

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copy your fat jar
COPY build/libs/portfolio-0.0.1-SNAPSHOT.jar app.jar
# Copy the keystore into the container
COPY src/main/resources/keystore.p12 keystore.p12

# Run the jar with SSL properties
ENTRYPOINT ["java", "-jar", "app.jar", \
  "--server.ssl.key-store=keystore.p12", \
  "--server.ssl.key-store-password=password", \
  "--server.ssl.key-store-type=PKCS12", \
  "--server.ssl.key-alias=jwt-key"]

