# OrderManagetmentSystem API

System that manages customer orders and reflects them in the database, in addition to having endpoints available to add new dishes.


## Scheme

![schema](https://github.com/user-attachments/assets/5514764b-9942-498e-b6d5-37c03de8f645)


## EndPoints Example

#### Get all items

```http
  POST /order/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `OrderDTO` | `ResponseEntity<>` | create a new order  |

#### Get item

```http
  GET /customer/orders/{id}
```

| Parameter |   Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `List<Order>` | Returns a list of a user's orders |





## FAQ

#### What is the utility?

You can use this as a starting point for an entire restaurant application.



## Author

- [@Joaquin-JvDev](https://github.com/Joa-JvDev)

