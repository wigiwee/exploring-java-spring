<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    
    <div class="container">
        <div class="card mx-auto mt-5 bg-secondary" style="width: 400px">
            <div class="card-body py-4">
                <h3 class="text-center text-white " style="text-transform: uppercase">My Search</h3>
                <form class="mt-3" action="search" method="GET">
                    <div class="form-group">
                        <input type="text"
                        name="querybox"
                        placeholder="Enter you keyword"
                        class="form-control"/>
                    </div>

                    <div class="container text-center">
                        <button class="btn btn-outline-Light">Search</button>
                    </div>
                </form>

            </div>
        </div>
    </div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>