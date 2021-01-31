pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarQubeMyPortfolio') {
                    sh './gradlew sonarqube \
                          -Dsonar.projectKey=SpringBoot-myPortfolioTools \
                          -Dsonar.host.url=http://localhost:9000 \
                          -Dsonar.login=fd7c6d802ee7496590b02454ef23014b6368894f'
                }
            }
        }
        stage ("Package") {
            steps {
        	    sh "./gradlew build"
        	}
        }
        stage ("Probar si funciona Docker") {
            steps {
                sh "docker version"
            }
        }
    }
}