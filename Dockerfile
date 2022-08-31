ARG IMAGE_NAME="eclipse-temurin"
ARG IMAGE_TAG="11-jdk"
FROM $IMAGE_NAME:$IMAGE_TAG


ARG GROUP_NAME="app"
ARG USER_NAME="app"
RUN addgroup --system $GROUP_NAME && adduser $USER_NAME --ingroup $GROUP_NAME

RUN mkdir /app
RUN chown -R $USER_NAME:$GROUP_NAME /app
RUN chmod 777 /app

USER $USER_NAME


ARG ARTIFACT_ID=demo-jenkins-pipeline-deploy-web
ARG VERSION=latest
COPY target/$ARTIFACT_ID-$VERSION.jar /app/app.jar

ENTRYPOINT java -jar /app/app.jar
