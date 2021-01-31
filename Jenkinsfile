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
                /*withCredentials([file(credentialsId: 'HOST_KEY', variable: 'hostKey'),
                                 file(credentialsId: 'TOKEN_LOGIN', variable: 'tokenLogin')]) {
                   sh "cp \$my-public-key /src/main/resources/my-public-key.der"
                   sh "cp \$my-private-key /src/main/resources/my-private-key.der"
                }*/
                withSonarQubeEnv('sonarQubeMyPortfolio') {
                    sh './gradlew sonarqube'
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