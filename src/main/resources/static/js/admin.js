function displayProduct(product) {
    return `<tr><td>${product.name}</td><td>${product.price}</td><td>${product.quantity}</td><td>${product.weight}</td>
            <td>${product.description}</td><td><img src="../static/images/${product.image}" alt="Lỗi"></td><td>${product.category.name}</td>
            <td>${product.description}</td><td><img src="../static/img/${product.image}" alt="Lỗi"></td><td>${product.category.name}</td>
            <td><button class="btn btn-danger" onclick="deleteProduct(${product.id})">Delete</button></td>
            <td><button class="btn btn-warning" onclick="editProduct(${product.id})">Edit</button></td></tr>`;
}