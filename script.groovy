def buildApp() {
    echo "building the application..."
}

def testApp() {
    echo "testing the application with version ${params.VERSION}"
}

// this is required to import in jenkins file 
return this