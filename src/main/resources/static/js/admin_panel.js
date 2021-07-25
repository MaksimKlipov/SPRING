
async function adminPanel() {
    let response = await fetch("/api/users")
    let data = await response.json()


    data.forEach(function (dt){
        $("#admin_panel").append(
            "<tr id='qwer'>"+
            "<td>"+dt.id+"</td>"+
            "<td>"+dt.username+"</td>"+
            "<td>"+dt.lastname+"</td>"+
            "<td>"+dt.age+"</td>"+
            "<td>"+dt.email+"</td>"+
            "<td>"+dt.roles+"</td>"+
            "<td>"+
            "<button type='button' class='btn btn-info' onclick='editModal("+dt.id+")' data-toggle='modal' data-target='#editModal'>Edit</button>"+
            "</td>"+
            "<td>"+
            "<button type='button' class='btn btn-danger' onclick='deleteModal("+dt.id+")' data-toggle='modal' data-target='#deleteModal'>Delete</button>"+
            "</td>"+
            "</tr>"
        )
    })

}
adminPanel()
