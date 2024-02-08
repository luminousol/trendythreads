FROM openjdk:17-jdk-slim

# 애플리케이션 정보를 위한 LABEL 추가
LABEL maintainer="luminousolding@gmail.com" \
      description="Spring Boot Application with OpenJDK 17"

# JAR 파일이 복사될 작업 디렉토리 설정
WORKDIR /app

# COPY에서 사용할 경로 변수 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

# jar 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]