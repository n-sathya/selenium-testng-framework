pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/n-sathya/selenium-testng-framework.git'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn clean test -Dheadless=true'
            }
        }
        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }
    }
}