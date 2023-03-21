pipeline {
    // master executor should be set to 0
    agent none
    stages {
        stage('Build Jar') {
                    agent {
                        docker {
                            image 'maven:3-alpine'
                            args '-v $HOME/.m2:/root/.m2'
                        }
                    }
                    steps {
                        sh 'mvn clean package -DskipTests'
                    }
                }
        stage('Build Image') {
                    steps {
                        script {
                        	app = docker.build("alfarazi/selenium-docker")
                        }
                    }
                }
        stage('Push Image') {
            steps {
//                     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
//                                         //sh
//                     bat "docker login --username=${alfarazi} --password=${Nerazuri11}"
//                     bat "docker push vinsdocker/selenium-docker:latest"

//                     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
//                     bat "docker login -u ${env.alfaraz'} -p ${env.Nerazuri11}"
//                     bat "docker push alfarazi/selenium-docker:latest"
                   // assumes Jib is configured to use the environment variables
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}