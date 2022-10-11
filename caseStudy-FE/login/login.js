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
            localStorage.setItem("role",data.appRole[0].name);
            localStorage.setItem("accountname",username);
            // localStorage.setItem("username",getStudent());


            if (data.appRole[0].name == "ROLE_ADMIN"){

                location.href = "http://localhost:63342/casestudy-final-backend-shop/caseStudy-FE/productBa/productControl.html?_ijt=6aa9ksqtmjo3r06ds2bacitbhs&_ij_reload=RELOAD_ON_SAVE"
            }else if (data.appRole[0].name == "ROLE_USER"){
                location.href="http://localhost:63342/casestudy-final-backend-shop/caseStudy-FE/user/usersList.html?_ijt=6aa9ksqtmjo3r06ds2bacitbhs&_ij_reload=RELOAD_ON_SAVE"
            }
        },
        error: function (err) {
            console.log(err)
        }
    })
}