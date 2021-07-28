
async function topPanel() {
    let response = await fetch("/api/user")
    let data = await response.json()

    $("#top_panel").append(
        "<table>"+
        "<tr id='"+data.email+"'>"+
        "<th>"+"<h3>"+data.email+" </h3>"+"<th>"+
        "<th>"+"<h3>"+"with roles:"+"</h3>"+"<th>"+
        "<th>"+"<h3>"+data.roles+"</h3id>"+"<th>"+
        "</tr>"+
        "</table>"
    )
}
topPanel()