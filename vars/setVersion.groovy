def call(String newVersion) {
    def conanFileExists = fileExists "conanfile.py"

    if(conanFileExists) {
        def file = readFile "conanfile.py"
        def lines = file.split("\n")
        String versionLine
        for (int i = 0; i< lines.size();i++){
            if(lines[i] =~ /(version) ?= ?['"].+['"]/){
                versionLine = lines[i]
            }
        }

        writeFile file: "conanfile.py", text: file.replaceAll(versionLine.trim(), "version = '${newVersion}'")
    }
}