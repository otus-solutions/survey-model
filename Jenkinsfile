pipeline {
	agent any
		tools {
			maven 'maven 3.5.0'
				jdk 'Java8'
		}

	stages {
		stage('Build Application') {
			steps {
				sh 'mvn -f survey-model/pom.xml clean package'
			}
		}

		stage('Unit tests') {
			steps {
				sh 'mvn -f survey-model/pom.xml test'
			}
		}

		stage('Publish artifact') {
			steps {
				sh 'mvn -f survey-model/pom.xml clean deploy'
			}
		}

		stage('Sonar Update') {
			steps {
				sh 'mvn -f survey-model/pom.xml sonar:sonar -Dsonar.host.url=${URL_SONAR} -Dsonar.password=${PWD_SONAR} -Dsonar.login=${USER_SONAR}'
			}
		}
	}

}
