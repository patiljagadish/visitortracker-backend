# Use official Java image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy project files
COPY . .

# Build the app using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Run the jar file
CMD ["java", "-jar", "target/visitortracker-0.0.1-SNAPSHOT.jar"]
