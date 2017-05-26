<html>
<body>
<h1>Shop Application</h1>
<h2>Prueba para desarrollador Java</h2>
<h4>Se dearrollo una aplicación REST con Spring MVC y Hibernate como frameworks. La BD diseñada en PostgreSQL 9.6 consta de 4 tablas:</h4>
<h4>ProductType, Product, Customer y Order las cuales simulan ordenes de compra de manera muy básica.</h4>

<h4>Ruta Principal: http://shop-ulisesbg.rhcloud.com/ShopApplication</h4>
<h4>Guía</h4>
<p>Tipos de Productos:</p>
<ol>
  <li>/getAllProductType</li>
  <li>/getProductType/{id}</li>
  <li>/getProductType?updateDate=yyyy-MM-dd</li>
  <li>/getProductTypeFromTo?fromDate=yyyy-MM-dd&toDate=yyyy-MM-dd</li>
</ol>
<p>Productos:</p>
<ol>
  <li>/getAllProduct</li>
  <li>/getProduct/{id}</li>
  <li>/getProduct?updateDate=yyyy-MM-dd</li>
  <li>/getProductFromTo?fromDate=yyyy-MM-dd&toDate=yyyy-MM-dd</li>
</ol>
<p>Clientes:</p>
<ol>
  <li>/getAllCustomer</li>
  <li>/getCustomer/{id}</li>
  <li>/getCustomer?updateDate=yyyy-MM-dd</li>
  <li>/getCustomerFromTo?fromDate=yyyy-MM-dd&toDate=yyyy-MM-dd</li>
</ol>
<p>Ordenes:</p>
<ol>
  <li>/getAllOrder</li>
  <li>/getOrder/{id}</li>
  <li>/getOrder?updateDate=yyyy-MM-dd</li>
  <li>/getOrderFromTo?fromDate=yyyy-MM-dd&toDate=yyyy-MM-dd</li>
</ol>

<h4>A continuación se muestran ejemplos de los servicios Rest que se pueden utilizar para obtener información:</h4>

<ul>
  <li>http://shop-ulisesbg.rhcloud.com/ShopApplication/getAllProductType</li>
  <li>http://shop-ulisesbg.rhcloud.com/ShopApplication/getProductType/1</li>
  <li>http://shop-ulisesbg.rhcloud.com/ShopApplication/getProduct?updateDate=2017-05-25</li>
  <li>http://shop-ulisesbg.rhcloud.com/ShopApplication/getOrderFromTo?fromDate=2017-05-25&toDate=2017-05-25</li>
</ul>

<h6>Developer ulisesbg</h6>
</body>
</html>
