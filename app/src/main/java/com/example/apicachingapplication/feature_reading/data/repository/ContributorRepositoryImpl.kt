package com.example.apicachingapplication.feature_reading.data.repository

import com.example.apicachingapplication.R
import com.example.apicachingapplication.feature_reading.domain.model.Contributor
import com.example.apicachingapplication.feature_reading.domain.repository.ContributorRepository
import javax.inject.Inject

class ContributorRepositoryImpl @Inject constructor(

): ContributorRepository {
    override suspend fun getContributors(): List<Contributor> {
        val contributors = listOf(
            Contributor(
                role = "creator",
                name = "Naveed Hafeez",
                bio = """
                Naveed Hafeez is the Creator and Project Manager of The Noble Quran. He established the vision behind the project and oversees its overall direction, development, and future growth. His goal is to create a modern, accessible, and user-friendly Quran application that makes reading and engaging with the Noble Quran easier for people around the world.

                Naveed is involved in planning the project's features, organizing development, making key project decisions, and ensuring that the app remains focused on its core purpose. From the initial concept to the ongoing development of the platform, he works closely with the design and development team to turn ideas into a complete and meaningful product.

                Through The Noble Quran, Naveed hopes to build more than just an application. He aims to create a reliable digital resource that provides users with a simple and respectful way to read, explore, and connect with the Quran across modern devices.
                """.trimIndent(),
                photo = R.drawable.naveed_hafeez
            ),
            Contributor(
                role = "designer",
                name = "Bawaqar Haider",
                bio = """
                Bawaqar Haider is the Designer of The Noble Quran, responsible for developing the project's visual identity, interface design, and overall user experience. His work focuses on creating an environment that is clean, modern, accessible, and comfortable for users who want to read and interact with the Quran digitally.

                Bawaqar works on the visual structure of the application, including layouts, typography, colours, icons, navigation, and other elements that contribute to the overall experience. He works closely with the Creator and Developer to ensure that the designs are not only visually appealing but also practical and easy to use.

                His approach is centred around simplicity and clarity, ensuring that the design supports the purpose of the application rather than distracting from it. Through his work, Bawaqar helps give The Noble Quran its visual identity while contributing to an experience that is welcoming and accessible to users of different backgrounds and levels of technical experience.
                """.trimIndent(),
                photo = R.drawable.bawaqar_haider
            ),
            Contributor(
                role = "developer",
                name = "Omare Faruk",
                bio = """
                Omare Faruk is the Developer of The Noble Quran, responsible for transforming the project's concepts and designs into a working application. He leads the technical development of the platform and works on implementing its core functionality, features, performance, and overall reliability.

                Omare works with the project team to turn planned features into practical software, ensuring that the application is structured to provide a smooth and consistent experience for users. His responsibilities include developing the application's functionality, integrating required technologies and services, improving performance, and addressing technical issues throughout the development process.

                Working closely with Naveed Hafeez and Bawaqar Haider, Omare helps bring the project's vision and designs together into a functional product. His contribution is an important part of building The Noble Quran into a reliable digital platform that can continue to grow and introduce new features in the future.
                """.trimIndent(),
                photo = R.drawable.omare_faruk
            )

        )
        return contributors
    }
}