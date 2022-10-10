function showAllProduct() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8095/products",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<tr><td>${data[i].id}</td>
                                <td>${data[i].dateTime}</td>
                                <td>${data[i].description}</td>
                                <td>${data[i].image}</td>
                                <td>${data[i].name}</td>
                                <td>${data[i].price}</td>
                                <td>${data[i].quantity}</td>
                                <td>${data[i].description}</td>
                                <td>${data[i].description}</td>
                                <td>${data[i].image}</td>`
            }
        }
    })
}