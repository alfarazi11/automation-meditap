pipeline {
    // master executor should be set to 0
    agent any
        stages {
             stage('Build Jar') {
//                         agent {
//                             docker {
//                                 image 'maven:3-alpine'
//                                 args '-v /root/.m2:/root/.m2'
//                             }
//                         }
                        steps {
                            bat "mvn clean package -DskipTests"
                        }
                    }
        stage('Build Image') {
                    steps {
                        script {
                        	app = docker.build("alfarazi/selenium-docker")
//                             bat "docker build -t alfarazi/selenium-docker -f ./Dockerfile.txt"
                        }
                    }
                }
        stage('Push Image') {
            steps {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
                    bat "docker login --username=${user} --password=${pass}"
                    bat "docker push alfarazi/selenium-docker:latest"

//                     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
//                     bat "docker login -u ${env.user'} -p ${env.pass}"
//                     bat "docker push alfarazi/selenium-docker:latest"
                   // assumes Jib is configured to use the environment variables
//                 script {
// 			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
// 			        app.push("${BUILD_NUMBER}")
// 			        app.push("latest")
// 			        }
                }
            }
        }
    }
}