
async function userPanel() {
    let response = await fetch("/api/user")
    let data = await response.json()


    $("#user_panel").append(
        "<tr>"+
        "<td>"+data.id+"</td>"+
        "<td>"+data.username+"</td>"+
        "<td>"+data.lastname+"</td>"+
        "<td>"+data.age+"</td>"+
        "<td>"+data.email+"</td>"+
        "<td>"+data.roles+"</td>"+
        "</tr>"
    )

}
userPanel()