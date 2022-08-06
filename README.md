
# Aplikacja Rezerwacji Obiektów


Port aplikacji: 8888


- Baza danych H2
- Username: user
- Password: pass
- localhost:8888/h2-console





## Działanie Aplikacji

#### A. Dodawanie nowej rezerwacji (nie może być dwóch rezerwacji tego samego oiektuw tym samym czasie)

```http
  Json POST localhost:8888/new-reservation

  {
    "dateStart": "2022-08-03",
    "dateEnd": "2022-08-09",
    "tenant": {"id":1},
    "landlord": {"id":1},
    "hotel": {"id":1}
}

```
```http

  curl -XPOST -H "Content-Type: application/json" -d '{
    "dateStart": "2022-01-03",
    "dateEnd": "2022-01-09",
    "tenant": {"id":1},
    "landlord": {"id":1},
    "hotel": {"id":1}
}' 'localhost:8888/new-reservation'
```


| Parameter | Typ     | Opis                 |
| :-------- | :------- | :------------------------- |
| `dateStart` | `DateTime` | **Wymanage**. Data rozpoczęcia  |
| `dateEnd` | `DateTime` | **Wymanage**. Data zakończenia  |
| `tenant` | `Tenant` | **Wymanage**. Obiekt lokatora/najemcy ( wystarczy id)  |
| `landlord` | `Landlord` | **Wymanage**. Obiekt właściciela ( wystarczy id) |
| `hotel` | `Hotel` | **Wymanage**. Obiekt hotelu ( wystarczy id) |


#### B. Zmiana daty obecnie istniejącej rezerwacji

```http
  Json POST localhost:8888/update-reservation

    {
        "oldReservation":{
            "id":1,
            "dateStart": "2022-08-01",
            "dateEnd": "2022-08-02",
            "tenant": {"id":1},
            "landlord": {"id":1},
            "hotel": {"id":1}
},

        "newReservation":{
                    "id":1,
                      "dateStart": "2022-08-19",
                      "dateEnd": "2022-08-25",
                      "hotel": {"id":1}
                     }
      }

```

```http
  curl -XPOST -H "Content-type: application/json" -d '{
        "oldReservation":{
            "id":1,
            "dateStart": "2022-08-01",
            "dateEnd": "2022-08-02",
            "tenant": {"id":1},
            "landlord": {"id":1},
            "hotel": {"id":1}
},

        "newReservation":{
                    "id":1,
                      "dateStart": "2022-08-19",
                      "dateEnd": "2022-08-25",
                      "hotel": {"id":1}
                     }
      }' 'localhost:8888/update-reservation'
```

| Parameter | Typ    | Opis                     |
| :-------- | :------- | :-------------------------------- |
| `oldReservation`      | `Reservation` | **Wymagane**. Obiekt starej rezerwacji |
| `newReservation`      | `Reservation` | **Wymagane**. Obiekt nowej rezerwacji |

#### C. Pobieranie listy rezerwacji dla zadanego najemcy (nazwa)

```http
GET localhost:8888/tenant-reservations?name=Lokator1

```
```http
curl -XGET 'localhost:8888/tenant-reservations?name=Lokator1'
```

| Parameter | Typ    | Opis                     |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Wymagane**. Nazwa najemcy |


#### D. Pobrać listę rezerwacji dla danego obiektu

```http
  GET localhost:8888/hotel-reservations?id=1

```
```http
  curl -XGET 'localhost:8888/hotel-reservations?id=1'
```

| Parameter | Typ    | Opis                     |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Wymagane**. id obiektu/hotelu |