pipeline {
    agent any
    stages {
        stage('Build Jar') {
//             agent {
//                 docker {
//                     image 'maven:3-alpine'
//                     args '-v $HOME/.m2:/root/.m2'
//                 }
//             }
            steps {
            //sh for mac
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t='alfarazi/selenium-docker'"
//                 script {
//                 	app = docker.build("alfarazi/selenium-docker")
//                 }
            }
        }
        stage('Push Image') {
            steps {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                                        //sh
                    bat "docker login --username=${user} --password=${pass}"
                    bat "docker push vinsdocker/selenium-docker:latest"

//                     withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Nerazuri11', usernameVariable: 'alfarazi')]) {
//                         bat "docker login -u ${env.alfaraz'} -p ${env.Nerazuri11}"
//                         bat "docker push alfarazi/selenium-docker:latest"
                   // assumes Jib is configured to use the environment variables
//                 script {
// 			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
// 			        	app.push("${BUILD_NUMBER}")
// 			            app.push("latest")
// 			        }
//                 }
            }
        }
    }
}