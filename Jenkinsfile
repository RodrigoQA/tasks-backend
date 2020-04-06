pipeline {
    agent any
    stages {
        stage ('Build Backend'){
            steps {
               bat 'mvn clean package -DskipTests=true'
            }
         }
         stage ('Unit Tests'){
            steps {
               bat 'mvn test'
            }
         }    
  stage ('Deploy Backend'){
           steps {
      deploy adapters: [tomcat8(credentialsId: 'LoginTomCat', path: '', url: 'http://localhost:8001')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
          }
      }
  stage ('API Test'){
      steps {
          dir('api-test'){
git credentialsId: 'LoginGitHub', url: 'https://github.com/RodrigoQA/tasks-api-test'
    bat 'mvn test'
        
         }
       }
    }
  }
}