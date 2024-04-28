pipeline {
    agent any
    tools{
        maven 'Maven_v3.9.6'
    }
    stages{
        stage("Build Maven"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ham2710/devOps-automation']])
                sh 'mvn clean install'
            }
        }
        stage("Build Docker Image"){
            steps{
                script{
                    sh 'docker build -t harshik2710/hibernate_demo_image .'
                }
            }
            
        }
        stage("Push Docker Image to Docker Hub"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u harshikpatel775@gmail.com -p ${dockerhubpwd}'
                    }
                    sh 'docker push harshik2710/hibernate_demo_image'
                        
                    
                }
            }
            
        }
    }
}