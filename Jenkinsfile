pipeline {
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
//                         bat "docker build -t alfarazi/selenium-docker -f Dockerfile ."
                        script {
                        //note alfarazi11 diambil dari user yg ada di hub.docker.com
                        	app = docker.build("alfarazi11/selenium-docker")

                        }
                    }
                }
        stage('Push Image') {
            steps {
//                     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
//                     bat "docker login --username=${user} --password=${pass}"
//                     bat "docker push alfarazi11/selenium-docker:latest"

//                     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
//                     bat "docker login -u ${env.user'} -p ${env.pass}"
//                     bat "docker push alfarazi/selenium-docker:latest"
                   // assumes Jib is configured to use the environment variables
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        app.push("${env.BUILD_NUMBER}")
			        app.push("latest")
			        }
                }
            }
        }
    }
}