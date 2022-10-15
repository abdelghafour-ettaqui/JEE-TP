<%@ page import="metier.entities.Produit" %>
<%@ page import="java.util.List" %>
<%@ page import="web.ProduitModel" %>
<%@ page import="javax.swing.plaf.ProgressBarUI" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="" %>--%>

<html>
<head>

    <title>Produits</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
 <div> Recherche des produits </div>
<div>
    <button>home</button>
    <button>add</button>
    <form action="chercher.php" method="get">

        <label for="search">Mot clé</label><input type="text" id="search" name="motCle"/>
        <button type="submit" >Chercher</button>
    </form>
    <table class="table-auto">
        <thead>
        <tr class="table-header">
            <th>id</th><th>désignation</th><th>prix</th><th>quantite</th><th>Supprimer</th><th>Edit</th>
        </tr>
        </thead>
            <%
                ProduitModel model = (ProduitModel)request.getAttribute("model");
                if(model != null){
                    List<Produit> products = model.getProduits();
                    for (Produit product : products) {%>
                        <tr>
                        <td><%= product.getId() %></td>
                        <td><%= product.getDesignation() %></td>
                        <td><%= product.getPrix() %></td>
                        <td><%= product.getQuantite() %></td>
                        <td><a onclick="return confirm('Etes vous sure?')" href="Supprime.php?id=<%= product.getId() %>">Supprimer</a> </td>
                        <td><a href="Edit.php?id=<%= product.getId() %>">Edit</a> </td>

                        </tr>
                    <%}
                }
            %>







    </table>
</div>


</body>
</html>
