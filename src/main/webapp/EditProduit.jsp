<%@ page import="metier.entities.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

  <title>Produits</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div> Edit produit </div>
<div>

  <%
    Produit product = (Produit)request.getAttribute("produit");

  %>

  <form action="UpdateProduit.php" method="post" >
    <div>
      <label for="id">ID</label>
      <input type="text" id="id"   name="id"/>
      <span></span>
    </div>
    <div>
      <label for="Désigantion">Désigantion</label>
      <input type="text" id="Désigantion"  name="designation"/>
      <span></span>
    </div>
    <div>
      <label for="Prix">Prix</label>
      <input type="text" id="Prix"  name="prix"/>
      <span></span>
    </div>
    <div>
      <label for="quantite">quantite</label>
      <input type="text" id="quantite"  name="quantite"/>
      <span></span>
    </div>
    <div>
      <button type="submit"> Save </button>
    </div>

  </form>


</div>


</body>
</html>
