<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="org.playload.helpline.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
        <h1>List of Users</h1>

        <table>
            <thead>
            <tr>
                <th>E-mail</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
            <tr>
                <td><a href="/user/${user.id}">${user.email}</a></td>
                <td>${user.role}</td>
            </tr>
            </#list>
            </tbody>
        </table>

    <#--
        <#if currentUser??>
            <li>
                <form action="/logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit">Log out</button>
                </form>
            </li>
            <li><a href="/user/${currentUser.id}">View myself</a></li>
        </#if>
        <#if currentUser?? && currentUser.role == "ADMIN">
            <li><a href="/user/create">Create a new user</a></li>
            <li><a href="/users">View all users</a></li>
        </#if>
        </ul>
    -->
</nav>
</body>
</html>