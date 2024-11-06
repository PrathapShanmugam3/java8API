FROM openjdk:8
# tzdata for timezone
RUN apt-get install -y tzdata

# timezone env with default
ENV TZ Asia/Kolkata
WORKDIR /usr/src/myapp
COPY target/devarCabs.jar /usr/src/myapp/ROOT.jar
EXPOSE 3506
ENTRYPOINT ["java", "-jar", "-Xmx2048m", "-Xms1024m", "ROOT.jar"]
