<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Insert title here</title>
    <link rel="stylesheet" href="calc3.css">
</head>

<body>
    <div>
        <form action="calc3" method="post">
            <table>
                <tr>
                    <td class="output" colspan="4">0</td>
                </tr>
                <tr>
                    <td><input name="operator" type="submit" value="CE" /></td>
                    <td><input name="operator" type="submit" value="C" /></td>
                    <td><input name="operator" type="submit" value="←" /></td>
                    <td><input name="operator" type="submit" value="/" /></td>
                </tr>
                <tr>
                    <td><input name="value" type="submit" value="7" /></td>
                    <td><input name="value" type="submit" value="8" /></td>
                    <td><input name="value" type="submit" value="9" /></td>
                    <td><input name="operator" type="submit" value="*" /></td>
                </tr>
                <tr>
                    <td><input name="value" type="submit" value="4" /></td>
                    <td><input name="value" type="submit" value="5" /></td>
                    <td><input name="value" type="submit" value="6" /></td>
                    <td><input name="operator" type="submit" value="-" /></td>
                </tr>
                <tr>
                    <td><input name="value" type="submit" value="1" /></td>
                    <td><input name="value" type="submit" value="2" /></td>
                    <td><input name="value" type="submit" value="3" /></td>
                    <td><input name="operator" type="submit" value="+" /></td>
                </tr>
                <tr>
                    <td><input name="button" type="submit" value=" " /></td>
                    <td><input name="value" type="submit" value="0" /></td>
                    <td><input name="value" type="submit" value="." /></td>
                    <td><input name="operator" type="submit" value="=" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>