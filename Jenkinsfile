pipeline {
    agent any

    environment {
        IMAGE_NAME = "springboot-jenkins-app"
        CONTAINER_NAME = "springboot-container"
    }

    stages {
        stage('Clone') {
            steps {
                git url: 'https://github.com/i-am-supremo/jenkins.git', credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Stop & Remove Old Container') {
            steps {
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                '''
            }
        }

        stage('Run New Container') {
            steps {
                sh '''
                docker run -d -p 8081:8081 --name $CONTAINER_NAME $IMAGE_NAME
                '''
            }
        }
    }
}
