async function deleteModal(id) {
    let response = await fetch('/api/users/' + id)
    let user = await response.json()

    $('#sel3 option').prop('selected', false);

    for (let i = 0; i < user.role.length; i++) {
        $(`#sel3 option[value="${user.role[i].id}"]`).prop('selected', true)
    }

    $('#dId').val(user.id)
    $('#dFirstName').val(user.username)
    $('#dLastName').val(user.lastname)
    $('#dAge').val(user.age)
    $('#dEmail').val(user.email)
    $('#dPassword').val(user.password)

}

$('#formDelete').submit(function (event) {
    event.preventDefault()
    let idUser = this.id.value
    fetch('/api/delete/' + idUser, {
        method: 'delete'
    }).then(res => console.log(res))

    setTimeout(function () {
        $('#' +idUser).remove()
    }, 100)

    $('#deleteModal').modal('hide')

})
