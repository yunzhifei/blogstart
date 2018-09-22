function checkLogin(form) {
    if (form.name.value() === '') {
        alert("请输入用户帐号!");
        form.name.focus();
        return false;
    }
    if (form.pwd.value === '') {
        alert("请输入密码！");
        form.pwd.focus();
        return false;
    }
    return true;
}