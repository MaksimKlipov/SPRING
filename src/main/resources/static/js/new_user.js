async function getRoles() {
    let response = await fetch("/api/roles")
    let data = await response.json()

    data.forEach(function (dt) {
        $('select').append('<option value="' + dt.id + '">' + dt.nameRole.substr(5) + '</option>')
    })

}

getRoles()

$(document).ready(function () {

    $('#formNewUser').submit(function (event) {
        event.preventDefault()

        let array = []

        let val = $('#sel2').val()

        for (let key in val) {
            array.push({"id": val[key]})
        }
        console.log(array)

        let data = {
            "username": this.username.value,
            "lastname": this.lastname.value,
            "age": this.age.value,
            "email": this.email.value,
            "password": this.password.value,
            "roles": array
        }

        console.log('Данные с формы New User', data)

        try {
            fetch('/api/save', {
                method: 'post',
                body: JSON.stringify(data),
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                }
            }).then(r => console.log('Успех', r))
        } catch (error) {
            console.error('Ошибка:', error);
        }

        setTimeout(function () {
            $('#admin_panel').html(adminPanel()),
                $('#formNewUser').get(0).reset(),
                $("#admin a:first").tab("show")
        }, 650)
    })
})
































