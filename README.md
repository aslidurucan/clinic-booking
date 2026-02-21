🏥 Clinic Booking – Backend

Bu proje, klinik randevu yönetim sistemi için geliştirilen Spring Boot tabanlı backend uygulamasıdır.

⚠️ Proje aktif geliştirme aşamasındadır. Yeni özellikler eklenmeye ve mimari yapı iyileştirilmeye devam edilmektedir.

🚀 Proje Amacı

Bu backend uygulamasının amacı:

Klinik randevu yönetimini sağlamak

Doktor, hasta ve randevu süreçlerini yönetmek

RESTful API üzerinden frontend ile iletişim kurmak

PostgreSQL veritabanı ile kalıcı veri yönetimi sağlamak

🛠️ Kullanılan Teknolojiler

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

Spring Validation

PostgreSQL

Lombok

Maven

📂 Proje Yapısı
backend
 └── src
     └── main
         ├── java/com/clinicbooking/backend
         │    ├── BackendApplication.java
         │    └── api/controllers
         │         └── HealthController.java
         └── resources
              └── application.yml
⚙️ Konfigürasyon

application.yml dosyasında PostgreSQL bağlantı ayarları tanımlıdır.

Projeyi çalıştırmadan önce:

PostgreSQL servisinin çalıştığından emin olun.

clinic_booking adında bir veritabanı oluşturun.

Gerekirse username ve password bilgilerini güncelleyin.

▶️ Uygulamayı Çalıştırma
1️⃣ Projeyi klonlayın
git clone <repo-url>
cd backend
2️⃣ Maven ile çalıştırın
./mvnw spring-boot:run

veya

mvn spring-boot:run

Uygulama varsayılan olarak aşağıdaki adreste çalışacaktır:

http://localhost:8080
🔎 Mevcut Endpoint
Health Check
GET /api/health

Response:

OK

Bu endpoint uygulamanın çalıştığını doğrulamak için eklenmiştir.

🧩 Planlanan Özellikler (Roadmap)

 Hasta (Patient) CRUD işlemleri

 Doktor (Doctor) yönetimi

 Randevu (Appointment) sistemi

 DTO yapıları

 Global Exception Handling

 Authentication & Authorization (JWT)

 Swagger / OpenAPI dokümantasyonu

 Katmanlı mimari (Service, Repository, Entity) genişletmesi

📌 Not

Bu proje geliştirme süreci devam eden bir backend uygulamasıdır.
Mimari yapı ve domain modeli ilerleyen aşamalarda genişletilecektir.
