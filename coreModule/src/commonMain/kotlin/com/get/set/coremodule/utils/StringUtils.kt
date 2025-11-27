fun String.getInitial(): String {
    if(this.contains(" ")) {
        val split = this.split(" ")
        return "${split[0].first()}${split[1].first()}";
    }else{
        return "SCC"
    }
}