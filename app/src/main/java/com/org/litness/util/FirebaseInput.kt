package com.org.litness.util

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.org.litness.data.source.model.ExerciseFB
import com.org.litness.data.source.model.FocusAreaFB

/**
    This class used for manually input to RealTime Database.
 */
object FirebaseInput {

    private val dbRefExercise = Firebase.database.getReference("Exercises")

    fun inputExercise() {
        for(exercise in listExercises) {
            dbRefExercise
                .child(exercise.id)
                .setValue(exercise)
        }
    }


    private val listExercises = listOf(
        ExerciseFB(
            id = "1",
            title = "Crunch",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FCrunch.jpg?alt=media&token=fb844ede-196a-4051-aeb1-85d4b21ceda6",
            steps = "<ol><li>Berbaring telentang pada permukaan lantai yang rata dengan beralaskan matras olahraga</li> <li>Tekuk lutut dengan posisi kedua telapak kaki menapak ke lantai, atau bisa juga ditekuk 90 derajat</li> <li>Kencangkan perut dengan mengangkat tubuh bagian atas. Pastikan untuk mengaktifkan otot perut, terutama otot rektus abdominis </li> <li>Angkat tubuh bagian atas ke atas, tetapi jangan sepenuhnya seperti sit-up. Fokus pada mengangkat bagian atas tubuh, seperti dada dan bokong</li> <li>Untuk melakukan bicycle crunch, gerakkan kaki di udara seperti mengayuh sepeda. Ini        melibatkan otot perut bagian atas dan bawah, serta otot paha</li>    <li>Ulangi gerakan ini sebanyak 10 kali, kemudian istirahatlah sebelum melanjutkan ke set berikutnya. Biasanya dilakukan 3 set dalam satu kali sesi latihan</li>    <li>Pastikan untuk melakukan pemanasan sebelum melakukan crunch, terutama jika Anda baru mulai olahraga. Jangan lupa untuk beristirahat jika merasa nyeri atau kram pada perut</li></ol>  ",
            focusAreas = mapOf(
                "1" to FocusAreaFB(
                    id = "1",
                    name = "Abs"
                )
            )
        ),
        ExerciseFB(
            id = "2",
            title = "Plank",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FPlank.jpg?alt=media&token=d1d1ce4f-5aa8-4b49-b11a-795fd36cde77",
            steps = "<ol><li>Berdiri dengan kaki selebar pinggul. Jika Anda merasa lebih nyaman, Anda bisa menempatkan kaki Anda sedikit lebih lebar dari pinggul </li>  <li>Bungkukkan badan hingga kedua telapak tangan menyentuh lantai. Pastikan siku Anda sejajar dengan bahu</li> <li>Letakkan pergelangan tangan di depan tubuh, sehingga bahu Anda sejajar dengan siku. Ini akan membantu Anda menjaga postur tubuh yang lurus</li> <li>Dorong kedua tangan ke depan tanpa bantuan kaki. Pastikan otot perut Anda tetap kencang dan            tubuh Anda dalam posisi lurus dari kepala hingga kaki</li> <li>Kesabaran adalah kunci untuk menahan gerakan plank. Mulai dengan waktu yang singkat dan secara bertahap meningkatkan waktu tahan Anda</li> </ol> ",
            focusAreas = mapOf(
                "1" to FocusAreaFB(
                    id = "1",
                    name = "Abs"
                )
            )
        ),
        ExerciseFB(
            id = "3",
            title = "Russian Twist",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FRussian%20Twist.jpg?alt=media&token=35b817d9-3ec4-4a90-a1e9-b38ec29a754b",
            steps = "<ol><li>Duduk di lantai dengan lutut ditekuk dan kaki diangkat. Pastikan kaki tidak menyentuh lantai  untuk mempertahankan postur yang baik</li>  <li>Pegang kettlebell, medicine ball, atau dumbbell dengan kedua tangan. Jika menggunakan  beban, pastikan pegangan yang kuat untuk menghindari cedera</li>    <li>Tekuk tubuh ke belakang hingga membentuk sudut sekitar 45 derajat dengan lantai. Pastikan  punggung tetap lurus untuk menghindari cedera</li> <li>Mulai berputar tubuh dari satu sisi ke sisi lain tanpa menggerakkan pinggul. Fokus pada otototot samping perut dan inti perut</li> <li>Lakukan gerakan putar minimal 15 repetisi. Jika ingin meningkatkan kesulitan, dapat menambahkan beban atau mengubah posisi tubuh </li> <li>Pastikan postur tubuh tetap tegak lurus dan tidak terlepas dari beban. Tekan otot-otot samping perut dengan kuat untuk memaksimalkan efektivitas latihan</li></ol>",
            focusAreas = mapOf(
                "1" to FocusAreaFB(
                    id = "1",
                    name = "Abs"
                )
            )
        ),
        ExerciseFB(
            id = "4",
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FSit-Up.jpg?alt=media&token=1981520f-b9ab-411a-a504-7421b95a23eb",
            title = "Sit-up",
            metScore = 3.8,
            steps = "<ol><li>Berbaring telentang di lantai atau bangku yang rata. Jika perlu, gunakan mat atau matras olahraga untuk memastikan punggung lebih nyaman</li> <li>Tekuk lutut dan tempelkan kaki ke lantai agar tubuh tetap stabil. Pastikan kedua telapak kaki menyentuh matras dengan pijakan yang kuat</li><li>Letakkan tangan dalam posisi silang di atas dada atau dekat telinga. Hindari meletakkan tangan di belakang kepala karena bisa menarik leher dan menyebabkan cedera</li> <li>Hembuskan nafas saat menaikan badan. Angkat tubuh bagian atas ke arah lutut, menggunakan otot bagian perut. Pastikan gerakan dilakukan dengan perlahan dan terkontrol</li><li>Setelah tubuh merapat ke arah lutut, kembalikan ke posisi berbaring telentang. Tarik napas saat turun kembali ke posisi awal</li><li>Hindari mengangkat tubuh bagian atas dengan menekan leher, menjatuhkan tubuh dengan cepat, tidak menjaga kaki rata, dan membungkukkan punggung saat mengangkat tubuh</li></ol>",
            focusAreas = mapOf(
                "1" to FocusAreaFB(
                    id = "1",
                    name = "Abs"
                )
            )
        ),
        // Arm
        ExerciseFB(
            id = "5",
            title = "Biceps Curl",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FBiceps%20Curl.jpg?alt=media&token=3003a768-5f36-4b34-94f4-d02af34e4cb8",
            steps = "<ol><li>Pilih alat yang akan digunakan, seperti dumbbell atau barbell</li> <li>Berdiri tegak dengan kaki selebar bahu</li> <li>Pegang alat dengan kedua tangan dengan jarak selebar bahu</li> <li>Tarik alat ke arah tubuh dengan mengangkat siku. Pastikan agar siku tetap menempel di sisi tubuh dan tidak bergerak</li><li>Lanjutkan gerakan hingga alat berada di dekat bahu</li><li>Tahan posisi tersebut selama satu detik</li><li>Turunkan alat perlahan-lahan kembali ke posisi awal</li> <li>Lakukan gerakan secara perlahan-lahan dan terkontrol untuk menghindari cedera</li><li>Lakukan sebanyak 15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),
        ExerciseFB(
            id = "6",
            title = "Lateral Raise",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FLateral%20Raise.jpg?alt=media&token=234978e8-1949-4f46-9225-55dacc265b55",
            steps = "<ol><li>Berdiri tegak dengan kaki selebar bahu. Pastikan postur tubuh Anda stabil dan tidak terlalu tegang</li><li>Pilih beban sesuai kemampuan</li><li>Pegang dumbbell di kedua tangan dengan posisi tangan menggantung di samping tubuh Anda. Telapak tangan menghadap ke dalam</li><li>Perlahan-lahan angkat kedua tangan ke samping hingga sejajar dengan bahu. Siku harus sedikit ditekuk dan tangan lurus</li><li>Berikan sedikit jeda di bagian atas gerakan sebelum menurunkan lengan kembali ke posisi awal. Ini membantu mengontrol gerakan dan mencegah cedera</li><li>Perlahan-lahan turunkan dumbbell kembali ke posisi semula, sambil mengontrol gerakan agar tetap stabil dan terkendali</li><li>Lakukan sebanyak 15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),
        ExerciseFB(
            id = "7",
            title = "Reverse Fly",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FReverse%20Fly.jpg?alt=media&token=1fe96fe5-9a3b-4c06-a59d-c8f41bce15d2",
            steps = "<ol><li>Pastikan kaki Anda terbuka selebar bahu untuk memastikan keseimbangan dan stabilitas tubuh</li><li>Pegang masing-masing tangan dengan dumbbell, dengan telapak tangan menghadap ke depan</li><li>Tekuk pinggang dan turunkan tubuh bagian atas hingga membentuk sudut 90 derajat. Ini akan membantu Anda menggerakkan lengan dengan lebih efektif</li><li>Biarkan dumbbell menggantung lurus ke bawah, dengan telapak tangan saling berhadapan</li><li>Kuatkan otot inti dan pastikan punggung tetap rata. Ini sangat penting untuk menghindari cedera dan memastikan gerakan yang efektif</li><li>Angkat lengan ke samping hingga lurus dengan tubuh. Pastikan siku tetap lembut dan tidak terlalu ditekuk</li><li>Turunkan lengan secara perlahan dan ulangi gerakan tersebut. Lakukan gerakan ini dengan ritme yang teratur untuk mendapatkan hasil yang optimal</li><li>Lakukan sebanyak 15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),
        ExerciseFB(
            id = "8",
            title = "Rope Push-down Machine",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FRope%20Pushdown%20Machine.png?alt=media&token=9357d0f2-e640-484a-a002-52adab53e087",
            steps = "<ol><li>Berdirilah di depan mesin kabel (cable machine) dengan kaki selebar pinggul dan tubuh tegak lurus</li><li>Pilih beban sesuai dengan kemampuan</li><li>Pegang bar dengan siku ditekuk menyerupai sudut 90 derajat. Pastikan siku Anda tepat disebelah batang tubuh</li><li>Turunkan lengan ke bawah dan rentangkan tali sedikit ke arah kanan dan kiri untuk merasakan kontraksi trisep. Pastikan posisi tangan Anda lurus</li><li>Tahan posisi tersebut untuk memicu kontraksi trisep. Anda dapat merasakan otot trisep bekerja saat lengan Anda lurus</li><li>Lakukan sebanyak 15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),
        ExerciseFB(
            id = "9",
            title = "Shoulder Press",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FShoulder%20Press.jpg?alt=media&token=91ff59c3-fb98-4603-ade5-1dab2ba752c2",
            steps = "<ol><li>Pegang sepasang dumbbell atau barbell dengan telapak tangan menghadap ke arah luar. Untuk pemula, lebih baik menggunakan dumbbell karena lebih mudah dikontrol</li><li>Berdiri tegak dengan kaki selebar bahu. Jika Anda pemula, Anda juga dapat duduk dengan posisi yang tegak</li><li>Dorong beban ke atas kepala hingga siku benar-benar terkunci. Pastikan punggung tetap lurus dan core terkunci untuk mendukung beban</li><li>Berhenti sebentar di atas kepala untuk memastikan posisi beban dan otot yang terlibat</li><li>Turunkan beban secara perlahan kembali ke posisi awal. Pastikan gerakan ini terkontrol untuk menghindari cedera</li><li>Lakukan sebanyak 15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),
        ExerciseFB(
            id = "10",
            title = "Standing Dumbbell",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FStanding%20Dumbbell.jpg?alt=media&token=08ffd691-cb3c-478d-83d0-58a1b78f0d75",
            steps = "<ol><li>Berdirilah tegak dengan kaki dibuka selebar bahu</li><li>Pegang dumbbell di masing-masing tangan dengan telapak tangan menghadap ke atas</li><li>Tekuk lengan bawah ke arah bahu sambil menjaga lengan atas tetap diam</li><li>Angkat dumbbell ke atas hingga siku tegak lurus dengan lantai. Pastikan untuk mengangkat beban dengan kontrol dan tidak menggoyangkan badan</li><li>Turunkan dumbbell kembali ke posisi awal secara perlahan. Jaga agar gerakan tetap terkontrol dan tidak terlalu cepat</li><li>Sesuaikan beban dan intensitas untuk memastikan bentuk tubuh yang tepat dan tantang diri Anda dengan tepat</li><li>Lakukan sebanyak 15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),
        ExerciseFB(
            id = "11",
            title = "Triceps Kick Back",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FTriceps%20Kick%20Back.jpeg?alt=media&token=bd2e5c6b-e99f-4630-bd5e-640baae0a3ee",
            steps = "<ol><li>Berdiri tegak dengan lutut ditekuk pada bangku atau platform setinggi lutut Anda. Jika tidak menggunakan bangku, Anda bisa berdiri tegak dengan punggung lurus</li><li>Letakkan satu tangan pada sebuah bangku atau platform dan pegang sebuah dumbbell pada tangan yang satunya. Pastikan posisi tangan yang memegang dumbbell sedikit ditekuk hingga membuat sudut 90°</li><li>Doronglah salah satu tangan yang memegang dumbbell ke arah belakang, jaga agar hanya siku Anda yang bergerak bukan lengan Anda yang bergerak ke belakang. Pastikan punggung tetap lurus selama gerakan</li><li>Setelah menggerakkan tangan ke belakang, kembali ke posisi semula. Lakukan gerakan ini pada tangan yang berikutnya</li> <li>Ulangi gerakan ini sebanyak 10-12 repetisi untuk setiap lengan. Jika Anda pemula, disarankan untuk menggunakan beban ringan terlebih dahulu</li></ol>",
            focusAreas = mapOf(
                "2" to FocusAreaFB(
                    id = "2",
                    name = "Arm"
                )
            )
        ),

        // back
        ExerciseFB(
            id = "12",
            title = "Dumbbell Row",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FDumbble%20Row.png?alt=media&token=f9931c8b-0390-49d1-882c-d2d813531d9f",
            steps = "<ol> <li>Berdiri dengan kaki dibuka selebar bahu</li><li>Masing-masing tangan memegang dumbbell dan arahkan kedua telapak tangan menghadap ke badan</li><li>Tekuk sedikit lutut dan pinggang hingga tubuh bagian atas menyerupai sudut 45 derajat menghadap lantai</li><li>Pilih dumbbell sesuai kemampuan</li><li>Selagi menjaga punggung tetap rata, tekuk lengan dan tarik dumbbell mendekati tulang rusuk</li><li>Perlahan luruskan lengan dan turunkan beban seperti pada posisi awal</li><li>Lakukan sebanyak 12-15 repetisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "3" to FocusAreaFB(
                    id = "3",
                    name = "Back"
                )
            )
        ),
        ExerciseFB(
            id = "13",
            title = "Lat Pull Down",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FLat%20Pull%20Down.jpg?alt=media&token=7d7e42c9-ce23-4d21-88e5-0ef17e9bbdbe",
            steps = "<ol><li>Pegang batang lat pull down dengan tangan yang sedikit lebih lebar dari bahu. Pastikan telapak tangan menghadap ke depan</li><li>Duduk dengan tangan lurus ke atas memegang batang lat pull down tersebut</li><li>Atur beban sesuai dengan kemampuan</li><li>Tarik batang lurus ke bawah hingga tepat di atas dada Anda. Anda juga bisa menarik batang tersebut ke belakang kepala hingga pada leher</li><li>Pastikan tangan Anda tetap dalam posisi yang benar, yaitu lebih lebar dari lebar bahu. Genggaman yang bagus adalah dengan jempol di atas atau searah dengan jari lainnya</li> <li>Hindari membiarkan beban menarik tangan Anda ke atas karena ini tidak efektif dan bisa menyebabkan cedera</li><li>Jangan membuat tubuh ikut naik dan turun untuk mempermudah tarikan karena ini tidak benar dan bisa menyebabkan cedera</li><li>Lakukan sebanyak 12-15 repetisi (3 set)</li></ol>",
            focusAreas = mapOf(
                "3" to FocusAreaFB(
                    id = "3",
                    name = "Back"
                )
            )
        ),
        ExerciseFB(
            id = "14",
            title = "Rope Pull Down",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FRope%20Pull%20Down.png?alt=media&token=d9ee7035-26f7-48c9-8bbd-3146920e1bb4",
            steps = "<ol><li>Berdiri di depan mesin rope pull yang biasanya terletak di pusat kebugaran atau gym</li> <li>Pegang tali yang terhubung dengan mesin rope pull dengan kedua tangan, pastikan posisi tangan lebih lebar dari bahu Anda</li><li>Atur beban sesuai kemampuan</li><li>Tarik tali ke bawah dengan kecepatan tetap, disertai dengan variasi pegangan untuk memaksimalkan kontraksi otot</li> <li>Gunakan kaki untuk memberikan kekuatan tambahan selama melakukan gerakan tarik tali ke bawah</li> <li>Lakukan variasi pegangan untuk memaksimalkan hasil, seperti mengganti pegangan overhand dengan pegangan neutral atau lainnya</li><li>Lakukan sebanyak 12-15 repetisi (3 set)</li></ol>",
            focusAreas = mapOf(
                "3" to FocusAreaFB(
                    id = "3",
                    name = "Back"
                )
            )
        ),
        ExerciseFB(
            id = "15",
            title = "Seated Row",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FSeated%20Row.jpg?alt=media&token=c6ab6f0a-4e98-4181-8916-6cbf3208121b",
            steps = "<ol><li>Duduklah di bangku yang dirancang untuk latihan Seated Row. Pastikan posisi tubuhmu tegak dan kaki terletak di pijakan yang tersedia</li><li>Pegang pegangan cable dengan kedua tangan, posisikan siku sejajar dengan dada. Jika menggunakan pegangan terpisah, pastikan gerakan dapat dilakukan lebih luas dan tekanan pada otot punggung bagian tengah lebih optimal</li><li>Bengkokkan lutut sedikit dan bungkukkan badan sedikit ke belakang. Kencangkan perut untuk mempertahankan stabilitas tubuh</li><li>Atur beban sesuai dengan kemampuan</li><li>Tarik cable perlahan-lahan sampai menyentuh perut. Rasakan tekanan yang diterima oleh otot punggung. Busungkan dada dan luruskan punggung untuk mempertahankan postur yang baik</li>    <li>Tahan sebentar dalam posisi yang telah ditemukan, lalu perlahan-lahan kembali ke posisi semula. Pastikan gerakan dilakukan dengan terkontrol dan perlahan-lahan</li><li>Lakukan sebanyak 12-15 repetisi (3 set)</li></ol>",
            focusAreas = mapOf(
                "3" to FocusAreaFB(
                    id = "3",
                    name = "Back"
                )
            )
        ),
        ExerciseFB(
            id = "16",
            title = "T-Bar Row",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FT%20Bar%20Row.jpg?alt=media&token=f0deccef-40dd-4bcc-95e0-cdbc303eb060",
            steps = "<ol><li>Berdiri di sisi batang T yang lain dengan kaki selebar bahu. Jika menggunakan mesin T-Bar, pastikan Anda berdiri di sisi yang tepat untuk mengangkat beban</li><li>Tekuk pinggul Anda sedikit dan tekuk lutut Anda untuk mendapatkan posisi tubuh yang stabil dan siap untuk melakukan gerakan</li><li>Pegang palang atau pegangan T-Bar dengan tangan Anda, pastikan posisi tangan Anda sedikit lebih lebar dari bahu. Jika menggunakan mesin, pastikan Anda memegangnya dengan benar dan kuat</li><li>Jaga punggung Anda tetap lurus dan inti tetap kencang. Angkat beban ke arah Anda dengan perlahan, pastikan otot punggung dan bahu Anda berkontraksi</li><li>Atur beban sesuai dengan kemampuan</li><li>Tarik beban ke arah Anda, lakukan gerakan secara perlahan untuk menghindari cedera. Saat menarik beban, pastikan siku Anda membentuk 45 derajat. Ini akan membantu melatih otot bisep dan punggung dengan efektif</li><li>Setelah menarik beban ke arah Anda, perlahan kembali ke posisi awal. Pastikan Anda mengontrol berat badan Anda dan mempertahankan bentuk yang benar untuk melakukan latihan T-Bar dengan aman</li><li>Lakukan sebantak 8-12 repetisi (3 set)</li></ol>",
            focusAreas = mapOf(
                "3" to FocusAreaFB(
                    id = "3",
                    name = "Back"
                )
            )
        ),

        // Chest
        ExerciseFB(
            id = "17",
            title = "Bench Press",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FBench%20Press.jpeg?alt=media&token=b65d7c09-3acc-471a-9232-c7a26db9a634",
            steps = "<ol><li>Lakukan peregangan ringan untuk mengsiapkan otot tubuh. Misalnya, dengan lari-lari kecil atau meregangkan otot kaki dan tangan agar tidak mudah mengalami nyeri saat berolahraga berat nanti</li><li>Atur beban sesuai dengan kemampuan</li><li>Berbaringlah di atas bench dengan punggung menyentuh permukaan bench secara penuh. Pastikan kaki tegak di lantai dan kaki selebar pinggul</li><li>Ambil barbell dengan posisi tangan sedikit lebih lebar dari lebar bahu. Pastikan kedua tangan sejajar dan kencang menggenggam barbell</li><li>Turunkan barbell secara perlahan ke arah dada dengan mengendurkan siku-siku secara perlahan. Pastikan untuk mengontrol gerakan ini dan menjaga stabilitas tubuh</li><li>Setelah barbell mencapai titik terendah di dada, doronglah kembali barbell ke atas dengan        mendorong barbell melawan gravitasi</li><li>Lakukan latihan bench press sebanyak 8-12 kali tiap setnya dengan jumlah set maksimal enam.</li></ol>",
            focusAreas = mapOf(
                "4" to FocusAreaFB(
                    id = "4",
                    name = "Chest"
                )
            )
        ),
        ExerciseFB(
            id = "18",
            title = "Butterfly Chest",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FButterfly%20Chest.jpg?alt=media&token=b28c399d-688a-4ade-86f7-41cd9beefb4d",
            steps = "<ol><li>Letakkan kedua tangan di depan dada dengan posisi siku tangan ditekuk 90 derajat. Telapak tangan menghadap ke muka</li><li>Buka kedua lengan ke samping hingga sejajar dengan bahu. Ini mirip dengan gerakan \"open  the window\" atau \"butterfly\" di mana lengan dibuka dan ditutup di depan wajah</li><li>Setelah membuka lengan, kembalikan posisi awal dengan menutup lengan di depan dada. Ini akan membantu melatih otot dada</li><li>Ulangi gerakan membuka dan menutup lengan secara berulang untuk memaksimalkan latihan otot dada.</li><li>Pastikan untuk mengontrol gerakan dengan baik dan tidak terlalu keras untuk menghindari cedera.</li><li>Lakukan latihan Butterfly Chest sebanyak 12-15 kali tiap setnya dengan jumlah set maksimal enam</li></ol>",
            focusAreas = mapOf(
                "4" to FocusAreaFB(
                    id = "4",
                    name = "Chest"
                )
            )
        ),
        ExerciseFB(
            id = "19",
            title = "Chest press Machine",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FChest%20Press%20Machine.jpg?alt=media&token=14a07a3a-78d0-41b4-8532-349c1e30000f",
            steps = "<ol><li>Duduk pada bangku chest press machine dengan punggung bertumpu pada sandaran dan kaki bertumpu pada pijakan chest press machine</li><li>Pegang gagang alat chest press dengan posisi telapak tangan menghadap ke bawah (overhand)</li><li>Posisikan siku menjauh ke luar samping tubuh dan pegangan tangan seharis horisontal dengan otot dada</li><li>Dorong pegangan ke depan hingga posisi tangan lurus dan siku sedikit menekuk. Pastikan pergelangan tangan tetap lurus dan tidak menekuk ke arah mana pun</li><li>Turunkan beban kembali pada posisi semula dengan menekuk siku tanpa ada sentuhan tumpukan beban pada mesin. Lakukan gerakan ini perlahan-lahan untuk menghindari cedera</li>    <li>Tarik napas pada saat menurunkan badan dari posisi siku lurus ke depan hingga siku menekuk ke samping tubuh. Buang napas dengan mendorong pegangan pada mesin dari posisi siku menekuk ke samping tubuh sampai siku lurus ke depan</li> <li>Lakukan latihan chest press machine sebanyak 12-15 kali tiap setnya dengan jumlah set maksimal enam</li></ol>",
            focusAreas = mapOf(
                "4" to FocusAreaFB(
                    id = "4",
                    name = "Chest"
                )
            )
        ),
        ExerciseFB(
            id = "20",
            title = "Decline Bench Press",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FDecline%20Bench%20Press.jpg?alt=media&token=32878bfb-1ade-44bc-b6dc-0215f03ee773",
            steps = "<ol><li>Lakukan peregangan ringan untuk mengsiapkan otot tubuh. Misalnya, dengan lari-lari kecil atau meregangkan otot kaki dan tangan agar tidak mudah mengalami nyeri saat berolahraga berat nanti</li><li>Atur beban sesuai dengan kemampuan</li><li>Berbaringlah di atas bench dengan punggung menyentuh permukaan bench secara penuh. Pastikan kaki tegak di lantai dan kaki selebar pinggul</li><li>Ambil barbell dengan posisi tangan sedikit lebih lebar dari lebar bahu. Pastikan kedua tangan sejajar dan kencang menggenggam barbell</li><li>Turunkan barbell secara perlahan ke arah dada dengan mengendurkan siku-siku secara perlahan. Pastikan untuk mengontrol gerakan ini dan menjaga stabilitas tubuh</li><li>Setelah barbell mencapai titik terendah di dada, doronglah kembali barbell ke atas dengan mendorong barbell melawan gravitasi</li>    <li>Lakukan latihan decline bench press sebanyak 8-12 kali tiap setnya dengan jumlah set maksimal enam</li></ol>",
            focusAreas = mapOf(
                "4" to FocusAreaFB(
                    id = "4",
                    name = "Chest"
                )
            )
        ),
        ExerciseFB(
            id = "21",
            title = "Incline Bench Press",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FIncline%20Bench%20Press.png?alt=media&token=186a8682-0d39-4ffd-b716-25a87d310203",
            steps = "<ol><li>Lakukan peregangan ringan untuk mengsiapkan otot tubuh. Misalnya, dengan lari-lari kecil atau meregangkan otot kaki dan tangan agar tidak mudah mengalami nyeri saat berolahraga berat nanti</li><li>Atur beban sesuai dengan kemampuan</li><li>Berbaringlah di atas bench dengan punggung menyentuh permukaan bench secara penuh. Pastikan kaki tegak di lantai dan kaki selebar pinggul</li><li>Ambil barbell dengan posisi tangan sedikit lebih lebar dari lebar bahu. Pastikan kedua tangan sejajar dan kencang menggenggam barbell</li><li>Turunkan barbell secara perlahan ke arah dada dengan mengendurkan siku-siku secara perlahan. Pastikan untuk mengontrol gerakan ini dan menjaga stabilitas tubuh</li><li>Setelah barbell mencapai titik terendah di dada, doronglah kembali barbell ke atas dengan        mendorong barbell melawan gravitasi</li><li>Lakukan latihan incline bench press sebanyak 8-12 kali tiap setnya dengan jumlah set maksimal enam.</li></ol>",
            focusAreas = mapOf(
                "4" to FocusAreaFB(
                    id = "4",
                    name = "Chest"
                )
            )
        ),

        // Leg
        ExerciseFB(
            id = "22",
            title = "Leg Extencions",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FLeg%20Extencions.jpg?alt=media&token=b4464368-b2cf-4ee9-a9dd-5e1aefd767db",
            steps = "<ol><li>Duduk pada mesin leg extension dengan punggung tegak lurus menempel pada sandaran mesin</li><li>Letakkan pergelangan kaki ke bawah bantalan mesin latihan. Pastikan kaki membentuk sudut siku-siku antara kaki bagian bawah dan kaki bagian atas (lower leg dan upper leg)</li><li>Genggamlah handle sebelah mesin dengan tangan yang kuat dan nyaman</li><li>Dorong beban ke atas dengan menggunakan otot quadriceps. Pastikan bahwa seluruh tubuh tetap dalam kondisi diam dan hindari panggul terangkat dari tempat duduk</li><li>Tahan kontraksi puncak sesaat. Jika sudut kaki kurang dari 90 derajat, itu dapat menyebabkan tekanan berlebih pada sendi lutut dan cedera</li><li>Perlahan-lahan turunkan beban kembali ke kondisi awal sambil menarik nafas. Pastikan tidak melewati batas sudut siku-siku</li><li>Lakukan sebanyak 12-15 repetisi (3 set) dan atur beban sesuai dengan kemampuan</li></ol>",
            focusAreas = mapOf(
                "5" to FocusAreaFB(
                    id = "5",
                    name = "Leg"
                )
            )
        ),
        ExerciseFB(
            id = "23",
            title = "Leg Press",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FLeg%20Press.jpeg?alt=media&token=a2747092-7b3e-4e08-a773-78342575bdb1",
            steps = "<ol><li>Pilih dan atur berat beban terlebih dahulu sesuai dengan kemampuan Anda</li><li>Duduk di mesin leg press dan letakkan kaki Anda pada platform di depan Anda dengan posisi kaki selebar bahu. Pastikan lutut lurus atau sejajar dengan kaki</li><li>Pegang dan rendahkan safety bar pada mesin leg press sambil menahan platform dengan kedua kaki. Genggamlah pegangan di samping alat dengan posisi lengan lurus di sisi samping tubuh</li><li>Dorong platform sampai kaki Anda lurus, tetapi jangan mengunci kaki Anda ketika dalam posisi lurus. Torso dan kaki sebaiknya membentuk sudut 90 derajat</li><li>Tarik nafas dan perlahan-lahan turunkan platform sampai posisi kaki atas dengan bawah membentuk sudut 90 derajat. Pastikan punggung bawah Anda tertekan pada bantalan punggung selama melakukan gerakan</li><li>Dorong kembali dengan menggunakan tumit dan aktifkan otot Quadriceps Anda untuk kembali ke posisi awal. Hembuskan nafas</li><li>Ketika selesai menggunakan mesin, jangan lupa mengunci safety pin pada mesin untuk mencegah platform tertiban</li><li>Lakukan sebanyak 12-15 repitisi (4 set)</li></ol>",
            focusAreas = mapOf(
                "5" to FocusAreaFB(
                    id = "5",
                    name = "Leg"
                )
            )
        ),
        ExerciseFB(
            id = "24",
            title = "Squat",
            metScore = 3.8,
            imgUrl = "https://firebasestorage.googleapis.com/v0/b/litness-ee32f.appspot.com/o/exercise%2FSquat.jpeg?alt=media&token=e7b16f50-566f-4b03-8caa-672fa4c38c00",
            steps = "<ol><li>Berdiri tegak dengan kaki selebar bahu. Jari-jari kaki melebar ke kiri dan kanan sekitar 15 derajat.</li><li>Pastikan lutut setengah ketekuk dan kedua tangan menggenggam barbell dengan overhand, tidak terlalu jauh dari kedua sisi pundak</li><li>Tekuk lutut hingga kedua kaki lurus. Pastikan genggaman pada barbell sudah kuat dan nyaman.</li><li>Turunkan tubuh Anda sejauh yang bisa Anda lakukan dengan mendorong punggung ke belakang. Pastikan tubuh bagian bawah harus sejajar dengan lantai dan dada dalam keadaan busung serta tidak membungkuk</li><li>Pada saat Anda menurunkan badan, naikkan lengan Anda hingga lurus ke depan untuk menjaga keseimbangan</li><li>Setelah menurunkan badan, angkat kembali badan dalam posisi berdiri tegak seperti semula. Lakukan hal tersebut secara berulang kali sesuai dengan kemampuan Anda</li><li>Lakukan sebanyak 8-12 repitisi (3 set) dana tur beban sesuai dengan kemampuan</li></ol>",
            focusAreas = mapOf(
                "5" to FocusAreaFB(
                    id = "5",
                    name = "Leg"
                )
            )
        ),
    )

    private val listFocusAreaFB = listOf(
        FocusAreaFB(
            id = "1",
            name = "Abs"
        ),
        FocusAreaFB(
            id = "2",
            name = "Arm"
        ),
        FocusAreaFB(
            id = "3",
            name = "Back"
        ),
        FocusAreaFB(
            id = "4",
            name = "Chest"
        ),
        FocusAreaFB(
            id = "5",
            name = "Leg"
        ),
    )
}