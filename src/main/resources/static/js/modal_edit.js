async function editModal(id) {

    let response = await fetch('/api/users/' + id)
    let user = await response.json()

    $('#sel1 option').prop('selected', false);

    for (let i = 0; i < user.role.length; i++) {
        $(`#sel1 option[value="${user.role[i].id}"]`).prop('selected', true)
    }

    $('#eId').val(user.id)
    $('#eFirstName').val(user.username)
    $('#eLastName').val(user.lastname)
    $('#eAge').val(user.age)
    $('#eEmail').val(user.email)
    $('#ePassword').val(user.password)

}

$('#formEdit').submit(function (event) {
    event.preventDefault()
    let array = []
    let val = $('#sel1').val()
    for (let key in val) {
        array.push({"id": val[key]})
    }
    let data = {
        "username": this.username.value,
        "lastname": this.lastname.value,
        "age": this.age.value,
        "email": this.email.value,
        "password": this.password.value,
        "roles": array
    }
    let idUser = this.id.value

    fetch('/api/update/' + idUser, {
        method: 'put',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    }).then(res => console.log(res))

    setTimeout(function () {
        $('#admin_panel').html(adminPanel()),
            $('#top_panel').html(topPanel()),
            $('#user_panel').html(userPanel())
    }, 100)

    $('#editModal').modal('hide')
})

