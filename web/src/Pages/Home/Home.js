import React  from 'react';
import Header from '../../Components/Header/Header';
import ServiceSection from '../../Components/ServiceSection/ServiceSection';
import AboutSection from '../../Components/AboutSection/AboutSection';
import AdvertisingSection from '../../Components/AdvertisingSection/AdvertisingSection';
import ProductsSection from '../../Components/ProductsSection/ProductsSection';

function Home() {

    return (
        <>
            <Header title="Tayyor tansiq taomlar sizni kutmoqda"/>
            <AboutSection image='./images/about-2.jpg'/>
            <ServiceSection/>
            <ProductsSection/>
            <AdvertisingSection/>
        </>
    )
}

export default Home
