# تطبيق موقع الكدادين (Android)

تطبيق أندرويد بسيط يعرض موقع الكدادين المباشر (https://dulcet-marigold-d21d4a.netlify.app/)
داخل شاشة كاملة بدون شريط متصفح — نفس الموقع 100%، بنفس بيانات Firebase الحية.

البناء يصير تلقائيًا على GitHub Actions عند كل رفعة (push) — ما يحتاج بناء يدوي على الجهاز.

## خطوات الرفع من ترامكس

```
pkg install git
git clone https://github.com/USERNAME/REPO_NAME.git
cd REPO_NAME
# فك ضغط ملفات هذا المشروع داخل هذا المجلد، ثم:
git add .
git commit -m "أول رفعة"
git push
```

بعد الرفع، روح لتبويب **Actions** بمستودع GitHub، انتظر لين يخلص البناء (علامة ✅ خضراء)،
افتح آخر تشغيلة، وحمّل ملف APK من قسم **Artifacts** بالأسفل.
