// To import the shared library to be used in the jenkins file
// If there wasn't a variable def gv after the library def we need to add a underscore at the end

@Library('jenkins-shared-lib')
def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    buildJar()
                }
            }
        }
        stage("build image") {
            // when {
            //     expression {
            //         BRANCH_NAME == 'master'
            //     }
            // }
            steps {
                script {
                    echo "building image"
                    buildImage 'anmol0503/docker-prac:3.0'
                }
            }
        }
        stage("deploy") {
            // when {
            //     expression {
            //         BRANCH_NAME == 'master'
            //     }
            // }
            steps {
                script {
                    echo "deploying"
                    gv.deployApp()
                }
            }
        }
    }   
}