node{
    stage('SCM Checkout' ) {
      git 'https://github.com/EmirhanDemirci/Spotifree-RestApi'
    }
    stage('Compile-Package') {
      sh 'mvn package'
    }
}
