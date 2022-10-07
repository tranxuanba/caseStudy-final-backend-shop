function login() {

    let username = $("#username").val();
    let password = $("#password").val();

    let appUser = {
        username: username,
        password: password
    }

    $.ajax({
        type: "POST",
        headers: {
            //kiểu dữ liệu nhận về
            // 'Accept': 'application/json',
            // kiểu truyền đi
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8095/login",
        data: JSON.stringify(appUser),
        //xử lý khi thành công
        success: function (data) {
            localStorage.setItem("token", data);
            location.href = "home.html"
        },
        error: function (err) {
            console.log(err)
        }
    })
}